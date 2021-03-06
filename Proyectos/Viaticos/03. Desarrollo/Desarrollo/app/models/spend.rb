class Spend < ActiveRecord::Base
  validates :tipo, presence: true
  validates :importe, presence: true, numericality: true
  
  belongs_to :proyect
  belongs_to :user
  has_attached_file :ticket, :styles => { :medium => "900x600>", :thumb => "600x900>" }, :default_url => "/images/:style/missing.png"
  validates_attachment_content_type :ticket, :content_type => /\Aimage\/.*\Z/
  
  #scopes
  include Scope
end
